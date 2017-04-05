package org.action;
import java.util.Map;
import org.dao.DlDao;
import org.dao.XxDao;
import org.dao.imp.DlDaoImp;
import org.dao.imp.XxDaoImp;
import org.model.Dlb;
import org.model.Xsb;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class LoginAction extends ActionSupport{
	// Dlb��������ڴ�ȡDlb���Ե�ֵ
	private Dlb dlb;
	// ������get��set����
	
	public Dlb getDlb() {
		return dlb;
	}

	public void setDlb(Dlb dlb) {
		this.dlb = dlb;
	}
	
	
	public String execute() throws Exception {
		DlDao dlDao=new DlDaoImp();//�õ�Dao�ӿڶ���
		Dlb user=dlDao.validate(dlb.getXh(), dlb.getKl());//����Dao�еķ���
		if(user!=null){
		//�����Ϊ�գ����浽Session��
			Map session=(Map)ActionContext.getContext().getSession();
			Dlb dlbl = null;
			dlbl = (Dlb) session.get("dlb");
			if(dlbl==null)
			{
				dlbl=dlb;
			}
			
			session.put("dlb", dlbl);
			session.put("xh",dlb.getXh());
			XxDao xxDao=new XxDaoImp();//�õ�Dao�ӿڶ���
			Xsb xs=xxDao.getXsb(dlb.getXh());
			session.put("xsxx",xs);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}




	
}
