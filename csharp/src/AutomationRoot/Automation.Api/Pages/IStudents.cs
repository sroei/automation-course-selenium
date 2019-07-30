using Automation.Api.Components;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Automation.Api.Pages
{
    public interface IStudents
    {
        IStudents FindByName(string name);
        IEnumerable<IStudent> Students();
    }
}
