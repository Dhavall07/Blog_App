package com.blog.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String password;
	private String about;
	@OneToMany(mappedBy= "user",cascade=CascadeType.ALL)
	private List<Post> posts = new ArrayList<>();
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="user_role", joinColumns=@JoinColumn(name="user",referencedColumnName="id"), inverseJoinColumns=@JoinColumn(name="role",referencedColumnName="id"))
	private Set<Role> roles = new HashSet<>();
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> collect= this.roles.stream().map((role)-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		return collect;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
//	public User() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public User(int id, String name, String email, String password, String about) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.email = email;
//		this.password = password;
//		this.about = about;
//	}
//	
//	
//	public User(int id, String name, String email, String password, String about, List<Post> posts) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.email = email;
//		this.password = password;
//		this.about = about;
//		this.posts = posts;
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getAbout() {
//		return about;
//	}
//	public void setAbout(String about) {
//		this.about = about;
//	}
//	
//	public List<Post> getPosts() {
//		return posts;
//	}
//	public void setPosts(List<Post> posts) {
//		this.posts = posts;
//	}
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", about=" + about
//				+ "]";
//	}
	
	
	
	
}
