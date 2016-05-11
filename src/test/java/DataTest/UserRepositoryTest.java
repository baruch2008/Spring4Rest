package DataTest;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tolfel.springrest.repositories.*;
import com.tolfel.springrest.entity.User;

public class UserRepositoryTest extends EntityDaoImplTest {
    @Autowired
    UserDao userDao;

    @Override
    protected IDataSet getDataSet() throws Exception{
        IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("user.xml"));
        return dataSet;
    }

    @Test
    public void findById(){
        Assert.assertNotNull(userDao.findById(1));
        Assert.assertNull(userDao.findById(3));
    }

    @Test
    public void saveUser() {
        int i = userDao.findAllUsers().size();
        User u = new User();
        u.setLogin("kok");
        u.setEmail("eke");
        u.setPassword("11111");
        u.setSteamUrl("w4v4");
        u.setRating(1);
        userDao.save(u);
        Assert.assertEquals(userDao.findAllUsers().size(),  i+1);
    }

    @Test
    public void findByLogin() {
        Assert.assertNotNull(userDao.findByLogin("SAMY"));
        Assert.assertNull(userDao.findByLogin("111"));
    }

    @Test
    public void deleteUser() {
        int i = userDao.findAllUsers().size();
        userDao.deleteByLogin("SAMY");
        Assert.assertEquals(userDao.findAllUsers().size(),  i-1);
    }


}
