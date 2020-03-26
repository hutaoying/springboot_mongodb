package com.one.springboot_mongodb.future;

public class Demo2 {
    public static void main(String[] args) {
        int a = 'A';
        System.out.println(a);
    }

    public int numRookCaptures(char[][] board) {
        int res =0;
        int row = board.length;
        int col = board[0].length;
        loop1:for(int i=0;i<row;i++){
            loop2:for(int j=0;j<col;j++){
                if('R' == (board[i][j])){
                    System.out.println("i:"+i +"::::j:"+j);
                    for(int k1 =j+1;k1<col;k1++){
                        if (board[i][k1] == 'B'){
                            break ;
                        }
                        if (board[i][k1] == 'p'){
                            res +=1;
                            break ;
                        }

                    }
                    for(int k1 =j-1;k1>=0;k1--){
                        if (board[i][k1] == 'B'){
                            break ;
                        }
                        if (board[i][k1] == 'p'){
                            res +=1;
                            break ;
                        }
                    }
                    for(int k1 =i-1;k1>=0;k1--){
                        if (board[i][k1] == 'B'){
                            break ;
                        }
                        if (board[i][k1] == 'p'){
                            res +=1;
                            break ;
                        }
                    }
                    for(int k2 =i+1;k2<row;k2++){
                        if (board[k2][j] == 'B'){
                            break ;
                        }
                        if (board[k2][j] == 'p'){
                            res +=1;
                            break ;
                        }
                    }

                }
            }
        }
        return 1;

    }

    public void fun(){
        for(int k1 =j-1;k1>=col;k1--){
            if (board[i][k1] == 'B'){
                break ;
            }
            if (board[i][k1] == 'p'){
                res +=1;
                break ;
            }
        }

    }
}
