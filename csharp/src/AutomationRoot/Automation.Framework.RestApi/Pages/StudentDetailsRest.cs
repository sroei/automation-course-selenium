using Automation.Api.Components;
using Automation.Api.Pages;
using Automation.Core.Components;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace Automation.Framework.RestApi.Pages
{
    public class StudentDetailsRest : FluentRest, IStudentDetails
    {
        public StudentDetailsRest(HttpClient httpClient) 
            : base(httpClient) { }

        public StudentDetailsRest(HttpClient httpClient, Core.Logging.ILogger logger)
            : base(httpClient, logger) { }

        public DateTime EnrollementDate()
        {
            throw new NotImplementedException();
        }

        public IEnrollment[] Enrollments()
        {
            throw new NotImplementedException();
        }

        public string FirstName()
        {
            throw new NotImplementedException();
        }

        public string LastName()
        {
            throw new NotImplementedException();
        }
    }
}
