/*
 * CS240-Program3 Author: Clare, Jianxiang, 02/25/19 
 * LLSoundList class. Using a linkedlist to operate sounds with append, insert, delete and play methods.
 */
public class LLSoundList
{
  private LLNode<Sound> head;//The head 
  public int nSounds;//number of nodes
  
  public LLSoundList(){
      head = null;
      nSounds = 0;
  }//constructor
  
  public void append(Sound s){
      LLNode<Sound> temp = new LLNode<Sound>(s);
      if(nSounds == 0){  //simply new first node
          head=temp;
          nSounds = 1;
          return; 
      }    
      LLNode<Sound> prior = head; //start at head
      for(int i=1; i<nSounds; i++){ //walk down to end of list
            prior=prior.getLink();
      }
      prior.setLink(temp); //old last sound now points to new last sound
      nSounds++;
      return;
  }
  
     //insert s before k-th node (counting from 1)
  public boolean insert(Sound s, int k)
  {
      
      LLNode<Sound> temp = new LLNode<Sound>(s);
      if(k==0){  //insert before head
          temp.setLink(head);
          head=temp;
          nSounds ++;
          return true; 
      }    
      LLNode<Sound> prior = head; //start at head
      for(int i=1; i<k; i++){ //walk down list until k-1
           prior=prior.getLink();
      }
      temp.setLink(prior.getLink());
      prior.setLink(temp);//link prior to the new node and link new node to the one that prior used to link with
      
      nSounds++;
      return true; 
}
  
     //delete k-th node (counting from 1)
  public boolean delete(int k){
    
    if(k==0){
      head=head.getLink();
    nSounds--;
    return true;
    
    }//delete head, just let the one which the old head linked become new head.
    LLNode<Sound> curr = head;
    for(int i=1;i<k;i++){
    curr=curr.getLink();
    }
      curr.setLink(curr.getLink().getLink());
// link the one before the deleting one to the one after the deleting one, skip the deleting one.
     
      nSounds--;
      return true;
  }

  
  public void play(int a,int b){
    LLNode<Sound> cur = head;
     if(a>nSounds){return ;}//if a is larger than nSound, nothing to play
    if(b>nSounds){
      b=nSounds;//if b is largar than nSound, play to end
    }
  
      for(int i=1;i<=b;i++){
        if(i>=a&&cur!=null){
          cur.getInfo().blockingPlay();}//if index larger than a, then play
         cur = cur.getLink();//always keep forward
    }
   
  }} 
 