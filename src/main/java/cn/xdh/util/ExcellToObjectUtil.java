package cn.xdh.util;

import cn.xdh.entity.Student;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcellToObjectUtil {
    //examId,realName,身份证,user_card,sex,没有字段,assessment_project,admission_number,seat_number

    /**
     * 读取xls文件内容
     *
     * @return List<XlsDto>对象
     * @throws IOException 输入/输出(i/o)异常
     */
    public static List<Student> readXls(POIFSFileSystem poifsFileSystem) throws IOException {
        //    InputStream is = new FileInputStream(filepath);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(poifsFileSystem);
        ExamInfo exam = null;
        List<ExamInfo> list = new ArrayList<ExamInfo>();
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }
                exam = new ExamInfo();
                // 循环列Cell
                HSSFCell examId = hssfRow.getCell(1);
                if (examId == null) {
                    continue;
                }
                double id = Double.parseDouble(getValue(examId));
                exam.setExamId((int) id);
                //        HSSFCell realName = hssfRow.getCell(2);
                //        if (realName == null) {
                //          continue;
                //        }
                //        exam.setRealName(getValue(realName));
                //        HSSFCell userCard = hssfRow.getCell(4);
                //        if (userCard == null) {
                //          continue;
                //        }
                //
                //        exam.setUserCard(getValue(userCard));
                HSSFCell admission_number = hssfRow.getCell(8);
                if (admission_number == null) {
                    continue;
                }
                exam.setAdmission_number(getValue(admission_number));
                HSSFCell seat_number = hssfRow.getCell(9);
                if (seat_number == null) {
                    continue;
                }
                exam.setSeat_number(getValue(seat_number));
                list.add(exam);
            }
        }
        return list;
    }

    public static List<ExamInfo> readXlsForJS(POIFSFileSystem poifsFileSystem) throws IOException {
//   InputStream is = new FileInputStream(filepath);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(poifsFileSystem);
        ExamInfo exam = null;
        List<ExamInfo> list = new ArrayList<ExamInfo>();
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }
                exam = new ExamInfo();
                // 循环列Cell 准考证号
                HSSFCell admission_number = hssfRow.getCell(0);
                if (admission_number == null) {
                    continue;
                }
                exam.setAdmission_number(getValue(admission_number));
                //读取身份证号
                HSSFCell userCard = hssfRow.getCell(2);
                if (userCard == null) {
                    continue;
                }
                exam.setUserCard(getValue(userCard));
                //读取座位号
                HSSFCell seat_number = hssfRow.getCell(3);
                if (seat_number == null) {
                    continue;
                }
                exam.setSeat_number(getValue(seat_number));
                //读取考场号
                HSSFCell fRoomName = hssfRow.getCell(6);
                if (fRoomName == null) {
                    continue;
                }
                exam.setfRoomName(getValue(fRoomName));
                //读取开考时间
                HSSFCell fBeginTime = hssfRow.getCell(8);
                if (fBeginTime == null) {
                    continue;
                }
                exam.setfBeginTime(getValue(fBeginTime));
                //读取结束时间
                HSSFCell fEndTime = hssfRow.getCell(9);
                if (fEndTime == null) {
                    continue;
                }
                exam.setfEndTime(getValue(fEndTime));
                list.add(exam);
            }
        }
        return list;
    }

    /**
     * 得到Excel表中的值
     *
     * @param hssfCell Excel中的每一个格子
     * @return Excel中每一个格子中的值
     */
    private static String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            DecimalFormat df = new DecimalFormat("0");
            String strCell = df.format(hssfCell.getNumericCellValue());
            return String.valueOf(strCell);
        } else {
            // 返回字符串类型的值
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
}
