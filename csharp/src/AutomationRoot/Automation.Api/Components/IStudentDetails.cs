using System;

namespace Automation.Api.Components
{
    public interface IStudentDetails
    {
        string FirstName();
        string LastName();
        DateTime EnrollementDate();
    }
}
