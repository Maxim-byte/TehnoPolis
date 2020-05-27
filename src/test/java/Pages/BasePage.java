package Pages;

public abstract class BasePage {
   //all pages constructors must check main elements on visibility and presented
   public BasePage() {
      check();
   }

   protected abstract void check();

}
