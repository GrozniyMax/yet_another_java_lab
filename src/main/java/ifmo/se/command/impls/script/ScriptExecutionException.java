package ifmo.se.command.impls.script;

/**
 * Исключение, возникающее при исполнении скрипта
 */
public class ScriptExecutionException extends RuntimeException {
    public ScriptExecutionException(Throwable cause) {
        super(cause);
    }

  public ScriptExecutionException() {
    super();
  }

  @Override
    public String getMessage() {
        return "Ошибка в исполнении скрипта " + getCause().getMessage();
    }
}
