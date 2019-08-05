namespace Automation.Api.Components
{
    public interface ICreate<out T>
    {
        T Create();
    }
}
