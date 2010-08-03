package br.com.navita.mobile.console.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import br.com.navita.mobile.console.bizz.LoginAwareService;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseLoginService extends BaseEntity implements LoginAwareService  {

}
