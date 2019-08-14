using Automation.Api.Components;
using Automation.Api.Pages;
using Automation.Core.Components;
using Automation.Core.Logging;
using Automation.Framework.RestApi.Components;
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
            : base(httpClient, logger) { }

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
            var response = HttpClient.GetAsync("https://gravitymvctestapplication.azurewebsites.net/api/Students").GetAwaiter().GetResult();
            if (!response.IsSuccessStatusCode)
            {
                return new IStudent[0];
            }
            var responseBody = response.Content.ReadAsStringAsync().GetAwaiter().GetResult();
            return JToken.Parse(responseBody).Select(i => new StudentRestApi(HttpClient, i));
        }
    }
}