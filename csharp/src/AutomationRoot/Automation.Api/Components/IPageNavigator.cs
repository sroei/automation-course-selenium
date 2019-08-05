namespace Automation.Api.Components
{
    public interface IPageNavigator<out T>
    {
        T Next();
        T Previous();
        int Pages();
        int Page();
    }
}
