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

namespace Automation.Framework.RestApi.Pages
{
    public class StudentsRest : FluentRestApi, IStudents
    {
        public StudentsRest(HttpClient httpClient)
            : this(httpClient, new TraceLogger()) { }

        public StudentsRest(HttpClient httpClient, ILogger logger)
            : base(httpClient, logger)
        {
            var response = httpClient.GetAsync("https://gravitymvctestapplication.azurewebsites.net/api/Students").GetAwaiter().GetResult();
            if (!response.IsSuccessStatusCode)
            {
                return;
            }
            var responseBody = response.Content.ReadAsStringAsync().GetAwaiter().GetResult();
            var token = JToken.Parse(responseBody);
        }

        public ICreateStudent Create()
        {
            throw new NotImplementedException();
        }

        public IStudents FindByName(string name)
        {
            throw new NotImplementedException();
        }

        public T Menu<T>(string menuName)
        {
            throw new NotImplementedException();
        }

        public IStudents Next()
        {
            throw new NotImplementedException();
        }

        public int Page()
        {
            throw new NotImplementedException();
        }

        public int Pages()
        {
            throw new NotImplementedException();
        }

        public IStudents Previous()
        {
            throw new NotImplementedException();
        }

        public IEnumerable<IStudent> Students()
        {
            throw new NotImplementedException();
        }
    }
}