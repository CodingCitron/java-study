package io.namoosori.travelclub.spring;

import io.namoosori.travelclub.spring.aggregate.club.CommunityMember;
import io.namoosori.travelclub.spring.aggregate.club.TravelClub;
import io.namoosori.travelclub.spring.service.ClubService;
import io.namoosori.travelclub.spring.service.MemberService;
import io.namoosori.travelclub.spring.service.sdo.MemberCdo;
import io.namoosori.travelclub.spring.service.sdo.TravelClubCdo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Date;

/* 테스트를 위한 클래스 */
public class TravelClubApp {
    public static void main(String[] args) {
        /* 스프링에게 ApplicaitonContext.xml 경로를 알려주어야 한다. */
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); /* XML로 읽는  */

        // 실제로 bean이 등록되어 있는지 확인하기
        String[] beanNames = context.getBeanDefinitionNames();
//        System.out.println(Arrays.toString(beanNames));
//
//        // 스프링 컨테이너로 하여금 빈을 생성하게 하고 그 빈을 찾는 코드
//        TravelClubCdo clubCdo = new TravelClubCdo("TravelClub", "Test TravelClub");
//        ClubService clubService = context.getBean("clubService", ClubService.class);
//
//        String clubId = clubService.registerClub(clubCdo);
//
//        TravelClub foundedClub = clubService.findClubById(clubId);
//        System.out.println("Club name: " + foundedClub.getName());
//        System.out.println("Club intro: " + foundedClub.getIntro());
//        System.out.println("Club foundationTime: " + new Date(foundedClub.getFoundationTime()));


        // 서비스 테스트
        MemberService memberService = context.getBean("memberServiceLogic", MemberService.class);
        String memberId = memberService.registerMember(new MemberCdo(
                "text@nextree.io",
                "Kim",
                "Test Member",
                "010-0000-0000",
                "2010.10.10")
        );

        CommunityMember foundedMember = memberService.findMemberById(memberId);
        System.out.println(foundedMember.toString());
    }
}
