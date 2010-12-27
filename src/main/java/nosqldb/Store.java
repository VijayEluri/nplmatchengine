package nosqldb;

import java.io.File;
import java.sql.ResultSet;

import org.apache.commons.io.FileUtils;

import bom.Author;
import bom.Doi;
import bom.Group;
import bom.Document;
import bom.Title;
import bom.Xnpl;

import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.persist.EntityCursor;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.StoreConfig;



public class Store {

	//private final Logger log = Logger.getLogger(getClass());

	private String dataDirectory;

	private Environment env;
	private EntityStore store;

	private DataAccessor dao;

	public Store() throws Exception {
		File dataDir = new File(dataDirectory);
		if (! dataDir.exists()) {
			FileUtils.forceMkdir(dataDir);
		}
		EnvironmentConfig environmentConfig = new EnvironmentConfig();
		environmentConfig.setAllowCreate(true);
		environmentConfig.setTransactional(true);
		env = new Environment(dataDir, environmentConfig);
		StoreConfig storeConfig = new StoreConfig();
		storeConfig.setAllowCreate(true);
		storeConfig.setTransactional(true);
		store = new EntityStore(env, dataDir.getName(), storeConfig);
		dao=new DataAccessor(store);
	}


	public void setDataDirectory(String dataDirectory) {
		this.dataDirectory = dataDirectory;
	}


	

	public void removeMember(long groupNum, String an) {
		dao.groupMemberByAN.delete(an);

	}

	public Group getGroupByGroupNum(long groupNum) {
		return dao.groupByGroupNum.get(groupNum);
	}

	public Group getGroupByAn(String an) {
		return dao.groupByAN.get(an);
	}

	public Group getGroupByDoi(String doi) {
		return dao.groupByDoi.get(doi);
	}

	public Group getGroupByXnpl(String xnpl) {
		return dao.groupByXnpl.get(xnpl);
	}

	public Group insertGroup(Doi doi, Xnpl xnpl, Title title, Author author, Document groupMember) {
		Group group=new Group(doi, xnpl,title,author);
		dao.insertGroup(group,groupMember);
/*		long groupNum=dao.groupByGroupNum.put(group).getGroupNum();
		GroupMember groupMember=new GroupMember(groupNum, an,supplierId);
		dao.groupMemberByAN.putNoReturn(groupMember);
		*/
		return group;
	}

	public void deleteGroup(long groupNum) {
		dao.groupByGroupNum.delete(groupNum);
	}

	/*public Group insertMember(GroupMember groupMember, Group group) {
		dao.groupMemberByAN.putNoReturn(groupMember);
		return group;
	}*/
	
	public void deleteMember(String an) {
		dao.groupMemberByAN.delete(an);
	}

	public void updateGroup(String stdAuthor, String stdTitle, String xnpl,
			String string, long groupNum) {
		// TODO Auto-generated method stub

	}

	public void updateGroup(String an, int supplierId, String members,
			long groupNum) {
		// TODO Auto-generated method stub

	}

	public void close() {
		// TODO Auto-generated method stub

	}

	public void truncate() {
		// TODO Auto-generated method stub

	}

	public void deleteAllUpdates() {
		// TODO Auto-generated method stub

	}

	public ResultSet selectUnexchangedUpdates() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setUpdatesToExchanged() {
		// TODO Auto-generated method stub

	}

	public Group selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getSupplierId(String an) {
		return dao.groupMemberByAN.get(an).getSupplierId();
		
	}

	public String descTable(String table) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUpdateGroup(long groupNum) {
		// TODO Auto-generated method stub

	}

	public ResultSet getStatNbGroups() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean isEmpty(long groupNum) {
		return getNbMembers(groupNum)==0?true:false;
	}

	public int getNbMembers(long groupNum) {
		int count=0;

		EntityCursor<Document> cursor = dao.groupMemberByGroupNum.entities(groupNum, true, groupNum, true);
	
		try {
			count=cursor.count();
		} finally {
				cursor.close();
		}
		return count;
	}

/*
	public void deleteGroup(Group group) {
		deleteGroup(group.getGroupNum());
		
	}
*/

	public Group insertMember(Document groupMember, Group group) {
		//return insertMember(an, supplierId, group.getGroupNum());
		return null;
		
	}


	public EntityCursor<Group> getMatchingGroups(String author, String title) {
		//AuthorTitle authorTitle = new AuthorTitle(author,title);
		//Group group =dao.groupByTitle.entities(title,true,title,true);
		return null;
	}

	public EntityCursor<Group> getMatchingGroups(String xnpl, String author, String title) {
		return dao.groupByXnpl.entities(xnpl,true,xnpl,true);
	}


	public void updateGroup(long groupNum, Document[] groupMembers) {
		// TODO Auto-generated method stub
		
	}


	public void updateGroupAuthor(Group group, Author stdAuthor) {
		group.setAuthor(stdAuthor);
		dao.groupByGroupNum.put(group);
	}

	public void updateGroupTitle(Group group, Title stdTitle) {
		group.setTitle(stdTitle);
		dao.groupByGroupNum.put(group);
	}

	
	public void updateGroupXnpl(Group group, Xnpl xnpl) {
		group.setXnpl(xnpl);
		dao.groupByGroupNum.put(group);
	}
	


}
