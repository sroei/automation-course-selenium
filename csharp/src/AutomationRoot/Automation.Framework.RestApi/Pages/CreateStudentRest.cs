using Automation.Api.Pages;
using Automation.Core.Components;
using Automation.Core.Logging;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;

namespace Automation.Framework.RestApi.Pages
{
    public class CreateStudentRest : FluentRest, ICreateStudent
    {
        // constants
        private const string F_NAME = "firstMidName";
        private const string L_NAME = "lastName";
        private const string E_DATE = "enrollmentDate";

        private readonly IDictionary<string, object> requestBody;

        public CreateStudentRest(HttpClient httpClient)
            : this(httpClient, new TraceLogger()) { }

        public CreateStudentRest(HttpClient httpClient, ILogger logger)
            : base(httpClient, logger)
        {
            requestBody = new Dictionary<string, object>();
        }

        public IStudents BackToList()
        {
            return new StudentsRest(HttpClient, Logger);
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
            requestBody[E_DATE] = enrollementDate.ToString("yyyy-MM-ddThh:mm:ss");
            return this;
        }

        public DateTime EnrollementDate()
        {
            return requestBody.ContainsKey(F_NAME) ? DateTime.Parse($"{requestBody[F_NAME]}") : default;
        }

        public ICreateStudent FirstName(string firstName)
        {
            requestBody[F_NAME] = firstName;
            return this;
        }

        public string FirstName()
        {
            return requestBody.ContainsKey(F_NAME) ? $"{requestBody[F_NAME]}" : string.Empty;
        }

        public ICreateStudent LastName(string lastName)
        {
            requestBody[L_NAME] = lastName;
            return this;
        }

        public string LastName()
        {
            return requestBody.ContainsKey(L_NAME) ? $"{requestBody[L_NAME]}" : string.Empty;
        }
    }
}