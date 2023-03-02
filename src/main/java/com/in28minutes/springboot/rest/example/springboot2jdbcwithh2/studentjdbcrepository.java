package com.in28minutes.springboot.rest.example.springboot2jdbcwithh2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class studentjdbcrepository {
    
	@Autowired
    JdbcTemplate jdbctemplate;
	
    class studentrowmapper implements RowMapper < student > {
        public student maprow(ResultSet rs, int rownum) throws SQLException {
            student student = new student();
            student.setid(rs.getLong("id"));
            student.setname(rs.getString("name"));
            student.setpassportnumber(rs.getString("passport_number"));
            return student;
        }

		@Override
		public student mapRow(ResultSet arg0, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

    }
    

    public student findbyid(long id) {
        return jdbctemplate.queryForObject("select * from student where id=?", new Object[] {
                id
            },
            new BeanPropertyRowMapper < student > (student.class));
    }
    
    public List <student> findall() {
        return jdbctemplate.query("select * from student", new studentrowmapper());
    }
    
    public int deletebyid(long id) {
        return jdbctemplate.update("delete from student where id=?", new Object[] {
            id
        });
    }

    public int insert(student student) {
        return jdbctemplate.update("insert into student (id, name, passport_number) " + "values(?,  ?, ?)",
            new Object[] {
                student.getid(), student.getname(), student.getpassportnumber()
            });
    }

    public int update(student student) {
        return jdbctemplate.update("update student " + " set name = ?, passport_number = ? " + " where id = ?",
            new Object[] {
                student.getname(), student.getpassportnumber(), student.getid()
            });
    }

    //metodo para buscar por nombre
    public List <student> findbyname(String name) {
        return jdbctemplate.query("select * from student where name=?", new Object[] {
                name
            },
            new BeanPropertyRowMapper < student > (student.class));
    }

    // metodo para buscar por el address
    public List <student> findbyaddress(String address) {
        return jdbctemplate.query("select * from student where address=?", new Object[] {
                address
            },
            new BeanPropertyRowMapper < student > (student.class));
    }
}
