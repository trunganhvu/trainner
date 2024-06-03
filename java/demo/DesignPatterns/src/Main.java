import Builder.Immutable.BankAccountImmutable;
import Builder.Mutable.BankAccountMutable;
import Builder.Mutable.BankAccountMutableBuilderImpl;
import FactoryPattern.BeanCase.AppConfig;
import FactoryPattern.BeanCase.Product;
import FactoryPattern.BeanCase.ProductFactory;
import FactoryPattern.EasyCase.Bank;
import FactoryPattern.EasyCase.BankFactory;
import FactoryPattern.EasyCase.BankType;

public class Main {
    public static void main(String[] args) {

        // Builder (Spring use as @Builder and BankObject.builder())
        builderPattern();

        // Factory (Spring use as @Bean to config can return new instant of project, and
        //          this new instant can call in Service, Controller is Dependency injection)
        factoryPattern();
    }

    /**
     * Builder
     */
    static void builderPattern() {
        // Builder with immuable attribute
        BankAccountImmutable newAccount = new BankAccountImmutable
                .BankAccountBuilder("name1", "111122")
                .email("test@mail.com")
                .newsletter(true)
                .build();
        System.out.println(newAccount);

        // Builder with mutabl attribute
        BankAccountMutable accountMutable = new BankAccountMutableBuilderImpl()
                .name("name")
                .accountNumber("111")
                .address("VN")
                .email("email@email.com")
                .mobileBanking(true)
                .newsletter(false)
                .builder();
        System.out.println(accountMutable);
    }

    static void factoryPattern() {
        // The common case
        Bank bank = BankFactory.getBank(BankType.TPBANK);
        System.out.println(bank.getBankName()); // TPBank

        // Instant of factory in spring
        Product product = AppConfig.getProduct();

        System.out.println(product);  // Output: Product{name='Product Name'}


    }
}