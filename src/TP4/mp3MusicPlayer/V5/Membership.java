package TP4.mp3MusicPlayer.V5;

import java.util.*;

public class Membership {

    private List<Member> memberList;

    public Membership() {
        this.memberList = new ArrayList<>();
    }

    public void ajouterMembre(Member member) {
        this.memberList.add(member);
        member.setEstInscrit(true);
    }

    public List<Member> getMemberList() {
        return this.memberList;
    }

    public boolean isMember(String nom) {
        for (Member member : memberList) {
            if (member.getNom().equals(nom)) {
                return true;
            }
        }
        return false;
    }

    public int getNumberOfMembers() {
        return this.memberList.size();
    }

    /**
     * On prend la musique la plus écoutée de chaque membre, et on les classe entre elles par ordre décroissant.
     *
     * @return
     */

    public List<Piste> trierParLesPistesLesPlusEcouteesDuClub() {
        List<Piste> pistes = new ArrayList<>();
        for (Member member : this.memberList) {
            if (!pistes.contains(member.getPistesPreferees().get(0))) {
                pistes.add(member.getPistesPreferees().get(0));
            }
        }
        Collections.reverse(Organizer.trierParNombreEcoutePiste(pistes));
        return pistes;
    }

    /**
     * On regarde le nombre d'écoutes de chaque membre et on les classe par ordre décroissant de nombre d'écoute.
     *
     * @return
     */

    public List<Member> trierParMembresQuiEcoutentLePlusDeMusique() {
        List<Member> memberList1 = new ArrayList<>(this.memberList);
        memberList1.sort(Comparator.comparing(Member::getNombreEcoutesTotaleDePistes).reversed());
        return memberList1;
    }

    public void desabonnerUnMembre(Member membre) {
        this.memberList.removeIf(member -> member.getNom().equals(membre.getNom()));
        membre.setEstInscrit(false);
        membre.reinitialiserDateInscription();

    }
}