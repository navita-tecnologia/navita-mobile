package br.com.navita.mobile.console.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseLoginService extends BaseEntity implements LoginService  {

}
