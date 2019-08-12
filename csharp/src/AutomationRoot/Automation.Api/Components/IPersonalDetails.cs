using System;

namespace Automation.Api.Components
{
    public interface IPersonalDetails
    {
        string FirstName();
        string LastName();
        DateTime EnrollementDate();
    }
}
