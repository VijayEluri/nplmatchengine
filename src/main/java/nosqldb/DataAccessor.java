package nosqldb;

import bom.Author;
import bom.Group;
import bom.Document;
import bom.Title;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.PrimaryIndex;
import com.sleepycat.persist.SecondaryIndex;


public class DataAccessor {
    // Group Accessors
    PrimaryIndex<Long,Group> groupByGroupNum;
    SecondaryIndex<Title, Long, Group> groupByTitle;
    SecondaryIndex<Author, Long, Group> groupByAuthor;
    SecondaryIndex<String, Long, Group> groupByDoi;
    SecondaryIndex<String, Long, Group> groupByXnpl;

    // GroupMember Accessors
    PrimaryIndex<String,Document> groupMemberByAN;
    SecondaryIndex<Long, String, Document> groupMemberByGroupNum;
	SecondaryIndex<String, Long, Group> groupByAN;

    // Open the indices
    public DataAccessor(EntityStore store)
        throws DatabaseException {

        // Primary key for Group class
    	groupByGroupNum = store.getPrimaryIndex(Long.class, Group.class);

        // Secondary key for Group classes
        // Last field in the getSecondaryIndex() method must be
        // the name of a class member; in this case, an Group
        // data member.
        groupByTitle = store.getSecondaryIndex(
        		groupByGroupNum, Title.class, "title");
        groupByAuthor = store.getSecondaryIndex(
        		groupByGroupNum, Author.class, "author");
        groupByDoi = store.getSecondaryIndex(
        		groupByGroupNum, String.class, "doi");
        groupByXnpl = store.getSecondaryIndex(
        		groupByGroupNum, String.class, "xnpl");
        groupByAN = store.getSecondaryIndex(
        		groupByGroupNum, String.class, "an");

        // Primary key for GroupMember class
    	groupMemberByAN = store.getPrimaryIndex(String.class, Document.class);

    	// Secondary key for GroupMember class
        groupMemberByGroupNum = store.getSecondaryIndex(groupMemberByAN, Long.class, "groupNum");

    }

	public void insertGroup(Group group, Document groupMember) {
		groupByGroupNum.put(group);
		groupMemberByAN.putNoReturn(groupMember);
		
	}



}
