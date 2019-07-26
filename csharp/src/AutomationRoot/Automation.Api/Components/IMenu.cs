namespace Automation.Api.Components
{
    public interface IMenu
    {
        T Menu<T>(string menuName);
    }
}