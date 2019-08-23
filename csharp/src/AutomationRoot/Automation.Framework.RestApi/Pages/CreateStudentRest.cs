using Automation.Api.Pages;
using Automation.Core.Components;
using Automation.Core.Logging;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace Automation.Framework.RestApi.Pages
{
    public class CreateStudentRest : FluentRest, ICreateStudent
    {
        private readonly IDictionary<string, object> requestBody;

        public CreateStudentRest(HttpClient httpClient)
            : base(httpClient) { }

        public CreateStudentRest(HttpClient httpClient, ILogger logger)
            : base(httpClient, logger)
        {
            requestBody = new Dictionary<string, object>();
        }

        public IStudents BackToList()
        {
            throw new NotImplementedException();
        }

        public IStudents Create()
        {
            var jsonRequest = JsonConvert.SerializeObject(requestBody);
            var content = new StringContent(jsonRequest, Encoding.UTF8, "application/json");
            HttpClient.PostAsync("/api/Students", content).GetAwaiter().GetResult();

            return new StudentsRest(HttpClient, Logger);
        }

        public ICreateStudent EnrollementDate(DateTime enrollementDate)
        {
            requestBody["enrollmentDate"] = enrollementDate.ToString("yyyy-MM-ddThh:mm:ss");
            return this;
        }

        public DateTime EnrollementDate()
        {
            throw new NotImplementedException();
        }

        public ICreateStudent FirstName(string firstName)
        {
            requestBody["firstMidName"] = firstName;
            return this;
        }

        public string FirstName()
        {
            throw new NotImplementedException();
        }

        public ICreateStudent LastName(string lastName)
        {
            requestBody["lastName"] = lastName;
            return this;
        }

        public string LastName()
        {
            throw new NotImplementedException();
        }
    }
}