package org.action;
import java.util.Map;
import java.util.Set;

import org.dao.DlDao;
import org.dao.GrDao;
import org.dao.XxDao;
import org.dao.imp.DlDaoImp;
import org.dao.imp.GrDaoImp;
import org.dao.imp.XxDaoImp;
import org.model.Dlb;
import org.model.Xsb;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class PersonXk extends ActionSupport{
	// Dlb��������ڴ�ȡDlb���Ե�ֵ
	
	
	public String execute() throws Exception {
		
		Map session=(Map)ActionContext.getContext().getSession();
		String xh = session.get("xh").toString();
		GrDao grDao=new GrDaoImp();//�õ�Dao�ӿڶ���
		Set kcbs = grDao.getKcb(xh);
		session.put("grkb",kcbs);
			return SUCCESS;
	}
}
