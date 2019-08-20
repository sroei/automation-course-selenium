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
    public class StudentsRest : FluentRest, IStudents
    {
        // members
        private readonly IEnumerable<IStudent> students;

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
            return students;
        }

        // build pipeline
        private IEnumerable<IStudent> Build(string name)
        {
            var response = HttpClient.GetAsync("/api/Students").GetAwaiter().GetResult();
            if (!response.IsSuccessStatusCode)
            {
                return new IStudent[0];
            }
            var responseBody = response.Content.ReadAsStringAsync().GetAwaiter().GetResult();
            var s = JToken.Parse(responseBody).Select(i => new StudentRest(HttpClient, i));

            // filter results
            const StringComparison COMPARE = StringComparison.OrdinalIgnoreCase;
            return string.IsNullOrEmpty(name)
                ? s
                : s.Where(i => i.FirstName().Equals(name, COMPARE) || i.LastName().Equals(name, COMPARE));
        }
    }
}