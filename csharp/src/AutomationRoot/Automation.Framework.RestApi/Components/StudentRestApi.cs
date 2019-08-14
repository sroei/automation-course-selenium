using Automation.Api.Components;
using Automation.Api.Pages;
using Automation.Core.Components;
using Automation.Core.Logging;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace Automation.Framework.RestApi.Components
{
    public class StudentRestApi : FluentRestApi, IStudent
    {
        private readonly JToken dataRow;
        private string firstName;
        private string lastName;
        private DateTime enrollementDate;

        public StudentRestApi(HttpClient httpClient, JToken dataRow)
            : this(httpClient, new TraceLogger())
        {
            this.dataRow = dataRow;
            Build(dataRow);
        }

        public StudentRestApi(HttpClient httpClient, ILogger logger)
            : base(httpClient, logger) { }

        public object Delete()
        {
            throw new NotImplementedException();
        }

        public IStudentDetails Details()
        {
            throw new NotImplementedException();
        }

        public object Edit()
        {
            throw new NotImplementedException();
        }

        public DateTime EnrollementDate()
        {
            return enrollementDate;
        }

        public string FirstName()
        {
            return firstName;
        }

        public string LastName()
        {
            return lastName;
        }

        // processing
        private void Build(JToken dataRow)
        {
        }
    }
}