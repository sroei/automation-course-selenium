using Automation.Api.Components;
using System;
using System.Collections.Generic;

namespace Automation.Api.Pages
{
    public interface IStudents
    {
        IStudents FindByName(string name);
        IEnumerable<IStudent> Students();
    }
}
