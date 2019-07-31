using Automation.Api.Components;
using Automation.Core.Components;
using System;
using System.Collections.Generic;

namespace Automation.Api.Pages
{
    public interface IStudents : IFluent, IPageNavigator<IStudents>, IMenu, ICreate<ICreateStudent>
    {
        IStudents FindByName(string name);
        IEnumerable<IStudent> Students();
    }
}