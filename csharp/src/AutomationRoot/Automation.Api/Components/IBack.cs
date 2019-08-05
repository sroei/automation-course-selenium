namespace Automation.Api.Components
{
    public interface IBack<out T>
    {
        T BackToList();
    }
}
