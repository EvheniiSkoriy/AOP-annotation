package source.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import source.dao.AccountDAO;
import source.dao.MembershipDAO;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);


        AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);

        accountDAO.addAccount(new Account(),true);
        System.out.println();

        //call the accountDAO getter/setter
        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();

        System.out.println();
        MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);

        membershipDAO.addSillyMember();

        context.close();

    }
}
