public class ShowPosts {
    static ShowPosts showPosts=new ShowPosts();
    User user;
    public void start(){

        String input="";
        while (!input.equals("-2")){
            System.out.println("All Posts :");
            System.out.println(user.PostCodesList.toString()+"\n Enter a PostCode to view the post \n Enter -2 to Exit");
            input=Main.scanner.nextLine();
            if (MAINInformation.mainInformation.posts.containsKey(input.trim())){
                if (MAINInformation.mainInformation.posts.get(input.trim()).Kind){
                    BusinessPost temp=(BusinessPost) MAINInformation.mainInformation.posts.get(input.trim());
                    temp.ShowBusPost();
                }
                else {
                    OrdinaryPost ordinaryPost=(OrdinaryPost) MAINInformation.mainInformation.posts.get(input.trim());
                    ordinaryPost.ShowPost();
                }
            }
            else {
                if (!input.equals("-2")){
                    System.out.println("PostCode Doesn't Exist");
                }
            }
        }
    }
}
