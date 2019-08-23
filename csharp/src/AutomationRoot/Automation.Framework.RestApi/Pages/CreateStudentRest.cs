using Automation.Api.Pages;
using Automation.Core.Components;
using Automation.Core.Logging;
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
        public CreateStudentRest(HttpClient httpClient)
            : base(httpClient) { }

        public CreateStudentRest(HttpClient httpClient, ILogger logger)
            : base(httpClient, logger) { }

        public IStudents BackToList()
        {
            throw new NotImplementedException();
        }

        public IStudents Create()
        {
            throw new NotImplementedException();
        }

        public ICreateStudent EnrollementDate(DateTime enrollementDate)
        {
            throw new NotImplementedException();
        }

        public DateTime EnrollementDate()
        {
            throw new NotImplementedException();
        }

        public ICreateStudent FirstName(string firstName)
        {
            throw new NotImplementedException();
        }

        public string FirstName()
        {
            throw new NotImplementedException();
        }

        public ICreateStudent LastName(string lastName)
        {
            throw new NotImplementedException();
        }

        public string LastName()
        {
            throw new NotImplementedException();
        }
    }
}