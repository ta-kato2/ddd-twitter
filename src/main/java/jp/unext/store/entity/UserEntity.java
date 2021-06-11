package jp.unext.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "member")
public class UserEntity extends PanacheEntityBase {

	@Id
	@Column(name = "user_id")
	public String userId;

	@Column(name = "name")
	public String name;

	@Column(name = "mail_address")
	public String mailAddress;
}
