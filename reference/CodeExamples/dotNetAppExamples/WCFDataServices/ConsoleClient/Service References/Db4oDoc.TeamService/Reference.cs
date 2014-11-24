//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.1
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

// Original file name:
// Generation date: 22.07.2010 16:38:41
namespace ConsoleClient.Db4oDoc.TeamService
{
    
    /// <summary>
    /// There are no comments for TeamDataContext in the schema.
    /// </summary>
    public partial class TeamDataContext : global::System.Data.Services.Client.DataServiceContext
    {
        /// <summary>
        /// Initialize a new TeamDataContext object.
        /// </summary>
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        public TeamDataContext(global::System.Uri serviceRoot) : 
                base(serviceRoot)
        {
            this.ResolveName = new global::System.Func<global::System.Type, string>(this.ResolveNameFromType);
            this.ResolveType = new global::System.Func<string, global::System.Type>(this.ResolveTypeFromName);
            this.OnContextCreated();
        }
        partial void OnContextCreated();
        /// <summary>
        /// Since the namespace configured for this service reference
        /// in Visual Studio is different from the one indicated in the
        /// server schema, use type-mappers to map between the two.
        /// </summary>
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        protected global::System.Type ResolveTypeFromName(string typeName)
        {
            if (typeName.StartsWith("Db4oDoc.WCFDataService", global::System.StringComparison.Ordinal))
            {
                return this.GetType().Assembly.GetType(string.Concat("ConsoleClient.Db4oDoc.TeamService", typeName.Substring(22)), false);
            }
            return null;
        }
        /// <summary>
        /// Since the namespace configured for this service reference
        /// in Visual Studio is different from the one indicated in the
        /// server schema, use type-mappers to map between the two.
        /// </summary>
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        protected string ResolveNameFromType(global::System.Type clientType)
        {
            if (clientType.Namespace.Equals("ConsoleClient.Db4oDoc.TeamService", global::System.StringComparison.Ordinal))
            {
                return string.Concat("Db4oDoc.WCFDataService.", clientType.Name);
            }
            return null;
        }
        /// <summary>
        /// There are no comments for Persons in the schema.
        /// </summary>
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        public global::System.Data.Services.Client.DataServiceQuery<Person> Persons
        {
            get
            {
                if ((this._Persons == null))
                {
                    this._Persons = base.CreateQuery<Person>("Persons");
                }
                return this._Persons;
            }
        }
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        private global::System.Data.Services.Client.DataServiceQuery<Person> _Persons;
        /// <summary>
        /// There are no comments for Teams in the schema.
        /// </summary>
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        public global::System.Data.Services.Client.DataServiceQuery<Team> Teams
        {
            get
            {
                if ((this._Teams == null))
                {
                    this._Teams = base.CreateQuery<Team>("Teams");
                }
                return this._Teams;
            }
        }
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        private global::System.Data.Services.Client.DataServiceQuery<Team> _Teams;
        /// <summary>
        /// There are no comments for Persons in the schema.
        /// </summary>
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        public void AddToPersons(Person person)
        {
            base.AddObject("Persons", person);
        }
        /// <summary>
        /// There are no comments for Teams in the schema.
        /// </summary>
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        public void AddToTeams(Team team)
        {
            base.AddObject("Teams", team);
        }
    }
    /// <summary>
    /// There are no comments for Db4oDoc.WCFDataService.Person in the schema.
    /// </summary>
    /// <KeyProperties>
    /// Email
    /// </KeyProperties>
    [global::System.Data.Services.Common.EntitySetAttribute("Persons")]
    [global::System.Data.Services.Common.DataServiceKeyAttribute("Email")]
    public partial class Person : global::System.ComponentModel.INotifyPropertyChanged
    {
        /// <summary>
        /// Create a new Person object.
        /// </summary>
        /// <param name="email">Initial value of Email.</param>
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        public static Person CreatePerson(string email)
        {
            Person person = new Person();
            person.Email = email;
            return person;
        }
        /// <summary>
        /// There are no comments for Property Name in the schema.
        /// </summary>
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        public string Name
        {
            get
            {
                return this._Name;
            }
            set
            {
                this.OnNameChanging(value);
                this._Name = value;
                this.OnNameChanged();
                this.OnPropertyChanged("Name");
            }
        }
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        private string _Name;
        partial void OnNameChanging(string value);
        partial void OnNameChanged();
        /// <summary>
        /// There are no comments for Property Email in the schema.
        /// </summary>
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        public string Email
        {
            get
            {
                return this._Email;
            }
            set
            {
                this.OnEmailChanging(value);
                this._Email = value;
                this.OnEmailChanged();
                this.OnPropertyChanged("Email");
            }
        }
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        private string _Email;
        partial void OnEmailChanging(string value);
        partial void OnEmailChanged();
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        public event global::System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        protected virtual void OnPropertyChanged(string property)
        {
            if ((this.PropertyChanged != null))
            {
                this.PropertyChanged(this, new global::System.ComponentModel.PropertyChangedEventArgs(property));
            }
        }
    }
    /// <summary>
    /// There are no comments for Db4oDoc.WCFDataService.Team in the schema.
    /// </summary>
    /// <KeyProperties>
    /// TeamName
    /// </KeyProperties>
    [global::System.Data.Services.Common.EntitySetAttribute("Teams")]
    [global::System.Data.Services.Common.DataServiceKeyAttribute("TeamName")]
    public partial class Team : global::System.ComponentModel.INotifyPropertyChanged
    {
        /// <summary>
        /// Create a new Team object.
        /// </summary>
        /// <param name="teamName">Initial value of TeamName.</param>
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        public static Team CreateTeam(string teamName)
        {
            Team team = new Team();
            team.TeamName = teamName;
            return team;
        }
        /// <summary>
        /// There are no comments for Property TeamName in the schema.
        /// </summary>
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        public string TeamName
        {
            get
            {
                return this._TeamName;
            }
            set
            {
                this.OnTeamNameChanging(value);
                this._TeamName = value;
                this.OnTeamNameChanged();
                this.OnPropertyChanged("TeamName");
            }
        }
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        private string _TeamName;
        partial void OnTeamNameChanging(string value);
        partial void OnTeamNameChanged();
        /// <summary>
        /// There are no comments for Property Motivation in the schema.
        /// </summary>
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        public string Motivation
        {
            get
            {
                return this._Motivation;
            }
            set
            {
                this.OnMotivationChanging(value);
                this._Motivation = value;
                this.OnMotivationChanged();
                this.OnPropertyChanged("Motivation");
            }
        }
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        private string _Motivation;
        partial void OnMotivationChanging(string value);
        partial void OnMotivationChanged();
        /// <summary>
        /// There are no comments for Members in the schema.
        /// </summary>
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        public global::System.Data.Services.Client.DataServiceCollection<Person> Members
        {
            get
            {
                return this._Members;
            }
            set
            {
                this._Members = value;
                this.OnPropertyChanged("Members");
            }
        }
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        private global::System.Data.Services.Client.DataServiceCollection<Person> _Members = new global::System.Data.Services.Client.DataServiceCollection<Person>(null, System.Data.Services.Client.TrackingMode.None);
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        public event global::System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Data.Services.Design", "1.0.0")]
        protected virtual void OnPropertyChanged(string property)
        {
            if ((this.PropertyChanged != null))
            {
                this.PropertyChanged(this, new global::System.ComponentModel.PropertyChangedEventArgs(property));
            }
        }
    }
}
