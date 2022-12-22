package cn.edu.jlu.bookshopping.repository;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import cn.edu.jlu.bookshopping.bean.User;

public interface UserRepository {
	
	//查找指定用户
	@Select("select * from user where loginname = #{loginname}")
	public User selectByUsername(String name);
	
	//将所有用户找出
	@Select("select * from user")
	public List<User> findAll();
	
	//更改用户金额！
	@Update("update user set money=#{money} where id=#{id}")
	public void update(User user);
	
	//插入新增普通用户值,金额默认 值100
	@Insert("insert into user(loginname,password,money)"
			+"value (#{loginname},#{password},{100})")
	public int insertUser(User user);
	
	//删除对应id的用户信息
	@Delete("delete from user where id=#{id}")
	public void delete(final Integer id);
	
}
