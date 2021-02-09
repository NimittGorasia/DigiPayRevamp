package com.Digipaywallet.DigiPayWalletRevamp.service;

import com.Digipaywallet.DigiPayWalletRevamp.vo.MailVO;
import com.Digipaywallet.DigiPayWalletRevamp.vo.UsersVO;

public interface NotificationService {

	public void sendNotification(UsersVO usersVO,MailVO mailVO);
}
