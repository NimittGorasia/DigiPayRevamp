package com.Digipaywallet.DigiPayWalletRevamp.dao;

import org.springframework.data.repository.CrudRepository;

import com.Digipaywallet.DigiPayWalletRevamp.entity.GenUsers;
import com.Digipaywallet.DigiPayWalletRevamp.vo.UsersVO;

public interface SignUpRepository extends CrudRepository<GenUsers, Long> {

	public GenUsers findByPhone(Long username);

}
