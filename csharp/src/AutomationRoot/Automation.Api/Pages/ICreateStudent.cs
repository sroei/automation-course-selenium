using Automation.Api.Components;
using System;

namespace Automation.Api.Pages
{
    public interface ICreateStudent : IStudentDetails, ICreate<IStudents>, IBack<IStudents>
    {
        ICreateStudent EnrollementDate(DateTime enrollementDate);

        ICreateStudent FirstName(string firstName);

        ICreateStudent LastName(string lastName);
    }
}