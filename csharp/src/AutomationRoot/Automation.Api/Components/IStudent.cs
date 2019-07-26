using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Automation.Api.Components
{
    public interface IStudent
    {
        string FirstName();
        string LastName();
        DateTime EnrollementDate();
        object Edit();
        object Details();
        object Delete();
    }
}
