
package gymproject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Calls the member list array and will output a message when a member is added or deleted.
 * @author Harry Clewlow, Leigh Lawley
 */
public class MemberDatabase implements Serializable {
    private static final long serialVersionUID = 19281017L;
    /**
     * Method to create an array holding the member details to be entered.
     */
    private ArrayList<Member> memberList = new ArrayList <Member>();
    private ArrayList<Member> blackListedMemberList = new ArrayList<Member>();

   
    public MemberDatabase() {
        
    }
    
    /**
     * Method to assign the array to a variable.
     * @param memberList to be called within other classes
     */
    public MemberDatabase(ArrayList<Member> memberList) {
        this.memberList = memberList;
    }
    
    /**
     * Method to output a confirmation message a member has been added.
     * @param memberToAdd 
     */
    public void addMember(Member memberToAdd) {
        if(memberList.add(memberToAdd)) {
        }
    }
    
    public ArrayList<Member> getList() {
        return memberList;
    }
    
    /**
     * Method to output a confirmation message a member has been deleted.
     * @param memberToDelete 
     */
    public void deleteMember(Member memberToDelete) {
        if(memberList.remove(memberToDelete)) {
            System.out.println("Member deleted!");
        } else {
            System.out.println("Member not added :(");
        }
    }
    
    
      public void addToBlacklist(Member memberToAdd) {
        blackListedMemberList.add(memberToAdd);
    }
      
      public void deleteBLMember(Member memberToDelete) {
        if(blackListedMemberList.remove(memberToDelete)) {
        } 
    }
    
      
     public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<Member> memberList) {
        this.memberList = memberList;
    }

    public ArrayList<Member> getBlackListedMemberList() {
        return blackListedMemberList;
    }

    public void setBlackListedMemberList(ArrayList<Member> blackListedMemberList) {
        this.blackListedMemberList = blackListedMemberList;
    }

    public boolean checkDetails(Member m1) {
       
        
        
        for(Member m : blackListedMemberList) {
            if(m1.getFirstName().equalsIgnoreCase(m.getFirstName()) && m1.getMiddleName().equalsIgnoreCase(m.getMiddleName()) && m1.getThirdName().equalsIgnoreCase(m.getThirdName()) && m1.getAge() == m.getAge())
            {
                return false;
            }
        }
        return true;
    }
     public ArrayList<Member> checkMember(String firstName, String lastName){
        ArrayList<Member> temp = new ArrayList<Member>();
        for (Member m : memberList) {
            
            if (m.getFirstName().equalsIgnoreCase(firstName) && m.getThirdName().equalsIgnoreCase(lastName))
            {
                temp.add(m);  
            }
            
        }
        return temp;
    }
    
}
