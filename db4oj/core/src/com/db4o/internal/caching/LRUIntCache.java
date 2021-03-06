/* Copyright (C) 2008  Versant Inc.  http://www.db4o.com */

package com.db4o.internal.caching;

import java.util.*;

import com.db4o.foundation.*;

/**
 * @exclude
 */
class LRUIntCache<V> implements PurgeableCache4<Integer, V> {
	
	private static class Entry<V> {
		
		final int _key;
		
		final V _value;
		
		Entry _previous;
		
		Entry _next;
		
		public Entry(int key, V value){
			_key = key;
			_value = value;
		}
		
		@Override
		public String toString() {
			return "" + _key;
		}
	}
	
	private final Hashtable4 _slots;
	
	private final int _maxSize;
	
	private int _size;
	
	private Entry _first;
	
	private Entry _last;
	

	LRUIntCache(int size) {
		_maxSize = size;
		_slots = new Hashtable4(size);
	}

	public V produce(Integer key, Function4<Integer, V> producer, Procedure4<V> finalizer) {
		int intKey = key;
		if(_last == null){
			V lastValue = producer.apply(key);
			if(lastValue == null){
				return null;
			}
			_size = 1;
			Entry lastEntry = new Entry(intKey, lastValue);
			_slots.put(intKey, lastEntry);
			_first = lastEntry;
			_last = lastEntry;
			return lastValue;
		}
		
		final Entry<V> entry = (Entry)_slots.get(intKey);
		
		if (entry == null) {
			if (_size >= _maxSize) {
				Entry oldEntry = (Entry) _slots.remove(_last._key);
				_last = oldEntry._previous;
				_last._next = null;
				if (null != finalizer) {
					finalizer.apply((V) oldEntry._value);
				}
				_size--;
			}
			V newValue = producer.apply(key);
			if (newValue == null) {
				return null;
			}
			_size++;
			Entry newEntry = new Entry(intKey, newValue);
			_slots.put(intKey, newEntry);
			_first._previous = newEntry;
			newEntry._next = _first;
			_first = newEntry;
			return newValue;
		}
		if(_first == entry){
			return entry._value;
		}
		Entry previous = entry._previous;
		entry._previous = null;
		if(_last == entry){
			_last = previous;
		}
		previous._next = entry._next;
		if(previous._next != null){
			previous._next._previous = previous;
		}
		_first._previous = entry;
		entry._next = _first;
		_first = entry;
		return entry._value;
	}

	public Iterator iterator() {
		Iterator4 i = new Iterator4 () {
			private Entry _cursor = _first;
			private Entry _current;
			public Object current() {
				return _current._value;
			}
			public boolean moveNext() {
				if(_cursor == null){
					_current = null;
					return false;
				}
				_current = _cursor;
				_cursor = _cursor._next;
				return true;
			}
			public void reset() {
				_cursor = _first;
				_current = null;
			}
		};
		return Iterators.platformIterator(i);
	}

	public V purge(Integer key) {
		int intKey = key;
		Entry<V> entry = (Entry<V>) _slots.remove(intKey);
		if(entry == null){
			return null;
		}
		_size --;
		if(_first == entry){
			_first = entry._next;
		}
		if(_last == entry){
			_last = entry._previous;
		}
		if(entry._previous != null){
			entry._previous._next = entry._next;
		}
		if(entry._next != null){
			entry._next._previous = entry._previous;
		}
		return entry._value;
    }
}

