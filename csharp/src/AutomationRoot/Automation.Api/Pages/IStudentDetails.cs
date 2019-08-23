using Automation.Api.Components;

namespace Automation.Api.Pages
{
    public interface IStudentDetails : IPersonalDetails
    {
        IEnrollment[] Enrollments();
    }
}