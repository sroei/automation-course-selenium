using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Automation.Api.Components
{
    public interface IStudent
    {
        string FirstName { get; }
        string LastName { get; }
        DateTime EnrollmentDate { get; }
    }
}
