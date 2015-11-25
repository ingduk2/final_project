package kosta.teamd.mvc.animal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kosta.teamd.mvc.dao.AnimalDao;
import kosta.teamd.mvc.dao.BoardDao;
import kosta.teamd.mvc.dao.CommBoardDao;
import kosta.teamd.mvc.service.AniboardImple;
import kosta.teamd.mvc.service.AnimalService;
import kosta.teamd.mvc.service.Paging;
import kosta.teamd.vo.AniBoardVO;
import kosta.teamd.vo.AnimalVO;
import kosta.teamd.vo.BoardVO;
import kosta.teamd.vo.CommBoardVO;



@Controller
public class AnimalController {
	
	//이미지게시판 dao
	@Autowired
	private AnimalDao adao;
	//댓글 dao
	@Autowired
	private CommBoardDao cbdao;
	@Autowired
	private BoardDao bdao;
	
	//이미지게시판 서비서(transactional용)
	@Autowired
	private AniboardImple abi;
	
	@Autowired
	private Paging page;
	
	
	// 이미지게시판 쓰기폼
	@RequestMapping(value="/formAnimal")
	public String formAnimal(){
		return "imgboard/imgboardwrite";
	}
	
	// 이미지게시판 insert 
	@RequestMapping(value="insertAnimal", method=RequestMethod.POST)	
	public ModelAndView insertAnimal(AnimalVO avo,BoardVO bvo ,HttpServletRequest request) {
		//세션에 request로 넘오온 세션 갑을 저장
		HttpSession session = request.getSession();
		//세션에서 실제경로를 받음
		String r_path= session.getServletContext().getRealPath("/");
		//이미지 저장폴더 이름
		
		//img가 있어서 upload로 바꿈
		String img_path = "\\upload\\";

		// 이미지 전체경로를 저장하기 위해 버퍼를 생성
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(img_path);
		System.out.println(path);
		// mutipartfile의 파일 이름을 가져옴
		String ofile = avo.getManiimg().getOriginalFilename();
		path.append(ofile);
		System.out.println(path);
		//file io 생성해서 이미지 경체 경로를 지정
		File f = new File(path.toString());
		try {
			//mutipartfile에 file을 넣어 전송
			avo.getManiimg().transferTo(f);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// file 이미지 이름을 저장
		avo.setAniimg(ofile);
		//insert 함
		abi.insert(bvo, avo);
		StringBuffer inspath = new StringBuffer();
		//폴더 경로 보고 바꿔주어야 함.
		///Users/ingduk2/git/final/TeamDfinal
		//선생님이랑 얘기를 해봐야할듯.. 파일이름겹치면 날라가버리고 사진 다 바뀌게 됨.
//		inspath.append("C:\\Users\\kosta\\git\\final\\TeamDfinal\\WebContent\\upload\\").append(ofile);
//		
//	     try {
//	    	 FileInputStream fis = new FileInputStream(path.toString()); 
//	    	 FileOutputStream fos = new FileOutputStream(inspath.toString()); 
//	    	 BufferedInputStream bis = new BufferedInputStream(fis); 
//	    	 BufferedOutputStream bos = new BufferedOutputStream(fos);
//	            int res = 0;
//	            while((res = bis.read()) != -1){
//	            bos.write(res);
//	        }
//	         if(bis != null)   bis.close();
//	         if(bos != null)   bos.close();
//	         if(fis != null)   fis.close();
//	         if(fos != null)   fos.close();
//	        } catch (FileNotFoundException ex) {
//	            ex.printStackTrace();  
//	        } catch(IOException ex){
//	            ex.printStackTrace();  
//	        }
//	     
		
		ModelAndView mav = new ModelAndView("redirect:/selectallAnimal");
    return mav;
	}
	
	@RequestMapping(value="/selectallAnimal")
	public ModelAndView selectallAnimal(@RequestParam(name="nowPage", defaultValue="1") int nowPage){
		List<AnimalVO> alist = adao.getImgList();
		ModelAndView mav = new ModelAndView("imgboard/imgboardlist");
		mav.addObject("alist", alist);
		mav.addObject("size",alist.size());
		int total = adao.imgCnt();
		System.out.println(total);
		String url = "selectallAnimal";
		String pagecode = page.Paging(total, nowPage, 5, 5, url);
		mav.addObject("page", pagecode);
		return mav;
	}
	
	@RequestMapping(value="/selectoneAnimal")
	public ModelAndView selectoneAnimal(int anino, int bno){
		// 조회수 
		bdao.hitBoard(bno);
		AniBoardVO avo = adao.imgDetail(anino);
		ModelAndView mav = new ModelAndView("imgboard/imgboarddetail");
		mav.addObject("avo", avo);
		List<CommBoardVO> cbvo = cbdao.commList(bno);
		mav.addObject("cbvo", cbvo);
		return mav;
	}
	
	
	@RequestMapping(value="/deleteAnimal")
	public ModelAndView deleteAnimal(int anino){
		System.out.println(anino);
		abi.delete(anino);
		return new ModelAndView("redirect:/selectallAnimal");
	}
	
	
	//이미지폼 실행
	@RequestMapping(value="/updateformAnimal")
	public ModelAndView updateformAnimal(int anino){
		AniBoardVO avo = adao.imgDetail(anino);
		ModelAndView mav = new ModelAndView("imgboard/imgupdate");
		mav.addObject("avo", avo);
		return mav;
	}
	
	
	//이미지 업로드 실행 
	@RequestMapping(value="/updateAnimal", method=RequestMethod.POST)
	public ModelAndView updateAnimal(AnimalVO avo,  BoardVO bvo,HttpServletRequest request){
		HttpSession session = request.getSession();
		String r_path = session.getServletContext().getRealPath("/");
		String img_path = "\\upload\\";
		String ofile = avo.getManiimg().getOriginalFilename();
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(img_path).append(ofile);
		System.out.println(path);
		File f = new File(path.toString());
		try {
			avo.getManiimg().transferTo(f);
		} catch (IllegalStateException | IOException e) {		
			e.printStackTrace();
		}
		avo.setAniimg(ofile);
		abi.update(bvo, avo);
		return new ModelAndView("redirect:/selectoneAnimal?anino="+avo.getAnino()+"&bno="+bvo.getBno());
	}
	
	//신고수 업데이트
	@RequestMapping(value="/updateRptAnimal")
	public ModelAndView updateRptAnimal(int bno, int anino){
		bdao.rpt(bno);
		ModelAndView mav = new ModelAndView("redirect:/selectoneAnimal");
		mav.addObject("bno", bno);
		mav.addObject("anino", anino);
		return mav;
	}
	
	
}
