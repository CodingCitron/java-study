package io.namoosori.travelclub.spring;

import io.namoosori.travelclub.spring.aggregate.club.TravelClub;
import io.namoosori.travelclub.spring.service.ClubService;
import io.namoosori.travelclub.spring.service.sdo.TravelClubCdo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/* 테스트를 위한 클래스 */
public class TravelClubApp {
    public static void main(String[] args) {
        /* 스프링에게 ApplicaitonContext.xml 경로를 알려주어야 한다. */
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); /* XML로 읽는  */

        // 실제로 bean이 등록되어 있는지 확인하기
        String[] beanNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanNames));

        // 스프링 컨테이너로 하여금 빈을 생성하게 하고 그 빈을 찾는 코드
        TravelClubCdo clubCdo = new TravelClubCdo("TravelClub", "Test TravelClub");
        ClubService clubService = context.getBean("clubService", ClubService.class);

        String clubId = clubService.registerClub(clubCdo);
        System.out.println("ID: " + clubId);
    }
}
