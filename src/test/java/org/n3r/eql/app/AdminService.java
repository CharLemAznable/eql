package org.n3r.eql.app;


import org.junit.Test;
import org.n3r.eql.Eql;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class AdminService {
    @Test
    public void test() {
        new Eql().id("setup").execute();
        Admin lvyong = findAdmin("lvyong");
        assertThat(lvyong, is(notNullValue()));
    }

    public Admin findAdmin(String username) {
        Admin admin = new Eql()
                .selectFirst("findAdmin")
                .params(username)
                .returnType(Admin.class)
                .execute();

        return admin;
    }

}
