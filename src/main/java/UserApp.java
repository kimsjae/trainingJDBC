import dao.UserDAO;
import model.Account;

import java.io.*;

public class UserApp {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            bw.write("입력은 1번, 변경은 2번, 삭제는 3번, 조회는 4번을 눌러주세요.\n");
            bw.flush();
            int num = Integer.parseInt(br.readLine());

            UserDAO dao = new UserDAO();

            if (num == 1) {
                bw.write("id, pw, grade, gender를 순서대로 입력하세요.\n");
                bw.flush();
                int result = dao.insert(br.readLine(), br.readLine(), Integer.parseInt(br.readLine()), br.readLine());
                if (result == 1) {
                    bw.write("입력 성공했습니다.\n");

                } else {
                    bw.write("입력 실패했습니다.\n");
                }
                bw.flush();
            }

            if (num == 2) {
                bw.write("변경할 pw와 해당 id를 입력하세요.");
                bw.flush();
                int result = dao.updateByNumber(br.readLine(), br.readLine());
                if (result == 1) {
                    bw.write("변경 성공했습니다.\n");
                } else {
                    bw.write("변경 실패했습니다.\n");
                }
                bw.flush();
            }

            if (num == 3) {
                bw.write("삭제할 id를 입력하세요.");
                bw.flush();
                int result = dao.deleteByNumber(br.readLine());
                if (result == 1) {
                    bw.write("삭제 성공했습니다.\n");
                } else {
                    bw.write("삭제 실패했습니다.\n");
                }
                bw.flush();
            }

            if (num == 4) {
                System.out.println(dao.selectAll());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

