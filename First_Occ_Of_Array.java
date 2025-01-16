package super150;
public class First_Occ_Of_Array {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 6, 3, 7};
        int item = 4;
        System.out.println(search(arr,item,0)) ;
    }
    public static int search(int[] arr , int item , int i){
        if(i==arr.length){
            return -1 ;
        }
        if(arr[i]==item){
            return i ;
        }
        return search(arr,item,i+1) ;
    }
}
