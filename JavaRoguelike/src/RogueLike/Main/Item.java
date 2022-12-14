package RogueLike.Main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Item implements Cloneable{
	
	private char glyph;
	public char glyph() {
		return glyph;
	}
	
	private char defaultGlyph;
	public char defaultGlyph() {
		return defaultGlyph;
	}
	
	public void changeGlyph(char newGlyph) {
		glyph = newGlyph;
	}
	
	private Color color;
	public Color color() {
		return color;
	}
	
	private Color defaultColor;
	public Color defaultColor() {
		return defaultColor;
	}
	
	public void changeColor(Color newColor) {
		color = newColor;
	}
	
	private String name;
	public String name() {
		String returnname = name;
		String upgradeLevel = "";
		String enchantmentName = "";
		
		if(this.upgradeLevel() > 0) {
			upgradeLevel = String.format("+%d ", this.upgradeLevel());
		}
		
		if(this.isEnchanted() > 0) {
			if(this.isArmor() > 0 || this.isShield() > 0) {
				enchantmentName = String.format("%s", this.enchantedName());
			}
			if(this.isWeapon() > 0) {
				enchantmentName = String.format("%s", this.enchantedName());
			}
		}
		
		if(this.isArmor() > 0 || this.isShield() > 0) {
			returnname = String.format("%s%s%s", upgradeLevel, name, enchantmentName);
		}
		
		if(this.isWeapon() > 0) {
			returnname = String.format("%s%s%s", upgradeLevel, enchantmentName, name);
		}
		return returnname;
	}
	
	public void changeName(String newName) {
		name = newName;
	}
	
	private String defaultName;
	public String defaultName() {
		return defaultName;
	}
	
	private String enchantedName;
	public String enchantedName() {
		return enchantedName;
	}
	
	public void setEnchantedName(String newName) {
		enchantedName = newName;
	}
	
	private String upgradeName;
	public String upgradeName() {
		return upgradeName;
	}
	
	public void setUpgradeName(String newName) {
		upgradeName = newName;
	}
	
	private String appearance;
	public String appearance() {
		if(appearance == null) {
			return name;
		}
		return appearance;
	}
	
	public void changeAppearance(String newAppearance) {
		appearance = newAppearance;
	}
	
	private String potionName;
	public String potionName() {
		return potionName;
	}
	
	public void setPotionName(String newName) {
		potionName = newName;
	}
	
	private int id;
	public int id() {
		return id;
	}
	
	public void setID(int amount) {
		id = amount;
	}
	
	private int isStackable;
	public int isStackable() {
		return isStackable;
	}
	
	public void modifyIsStackable(int amount) {
		isStackable += amount;
	}
	
	private int stackAmount;
	public int stackAmount() {
		return stackAmount;
	}
	
	public void modifyStackAmount(int amount) {
		stackAmount += amount;
	}
	
	public void setStackAmount(int amount) {
		stackAmount = amount;
	}
	
	private int baseGoldValue;
	public int baseGoldValue() {
		return baseGoldValue;
	}
	
	public void setBaseGoldValue(int amount) {
		baseGoldValue = amount;
	}
	
	private int currentGoldValue;
	public int currentGoldValue() {
		return currentGoldValue;
	}
	
	public void setCurrentGoldValue(int amount) {
		currentGoldValue = amount;
	}
	
	public void modifyCurrentGoldValue(int amount) {
		currentGoldValue += amount;
	}
	
	private int foodValue = 0;
	public int foodValue() {
		return foodValue;
	}
	
	public void modifyFoodValue(int amount) {
		foodValue += amount;
	}
	
	private int visionRadius;
	public int visionRadius() {
		return visionRadius;
	}
	
	public void modifyVisionRadius(int amount) {
		visionRadius += amount;
	}
	
	private double attackValue;
	public double attackValue() {
		return attackValue;
	}
	
	public void modifyAttackValue(double amount) {
		attackValue += amount;
	}
	
	public void setAttackValue(double amount) {
		attackValue = amount;
	}
	
	private int damageDiceLowerBound = 1;
	public int damageDiceLowerBound() {
		return damageDiceLowerBound;
	}
	
	public void modifyDamageDiceLowerBound(int amount) {
		damageDiceLowerBound += amount;
	}
	
	public void setDamageDiceLowerBound(int amount) {
		damageDiceLowerBound = amount;
	}
	
	private int damageDice;
	public int damageDice() {
		return damageDice;
	}
	
	public void modifyDamageDice(int amount) {
		damageDice += amount;
	}
	
	public void setDamageDice(int amount) {
		damageDice = amount;
	}
	
	private int thrownDamageDice;
	public int thrownDamageDice() {
		return thrownDamageDice;
	}
	
	public void modifyThrownDamageDice(int amount) {
		thrownDamageDice += amount-1;
	}
	
	public void setThrownDamageDice(int amount) {
		thrownDamageDice = amount;
	}
	
	private int rangedDamageDice;
	public int rangedDamageDice() {
		return rangedDamageDice;
	}
	
	public void modifyRangedDamageDice(int amount) {
		rangedDamageDice += amount;
	}
	
	public void setRangedDamageDice(int amount) {
		rangedDamageDice = amount;
	}
	
	private int dealsFire;
	public int dealsFire() {
		return dealsFire;
	}
	public void modifyDealsFire(int amount) {
		dealsFire += amount;
	}
	
	private int dealsFrost;
	public int dealsFrost() {
		return dealsFrost;
	}
	public void modifyDealsFrost(int amount) {
		dealsFrost += amount;
	}
	
	private int dealsShock;
	public int dealsShock() {
		return dealsShock;
	}
	public void modifyDealsShock(int amount) {
		dealsShock += amount;
	}
	
	private int dealsPoison;
	public int dealsPoison() {
		return dealsPoison;
	}
	public void modifyDealsPoison(int amount) {
		dealsPoison += amount;
	}
	
	private int dealsAcid;
	public int dealsAcid() {
		return dealsAcid;
	}
	public void modifyDealsAcid(int amount) {
		dealsAcid += amount;
	}
	
	private int dealsMagic;
	public int dealsMagic() {
		return dealsMagic;
	}
	public void modifyDealsMagic(int amount) {
		dealsMagic += amount;
	}
	
	private int dealsChaos;
	public int dealsChaos() {
		return dealsChaos;
	}
	public void modifyDealsChaos(int amount) {
		dealsChaos += amount;
	}
	
	private double defenseValue;
	public double defenseValue() {
		return defenseValue;
	}
	
	public void modifyDefenseValue(double amount) {
		defenseValue += amount;
	}
	
	public void setDefenseValue(double amount) {
		defenseValue = amount;
	}
	
	private double fireDefenseValue;
	public double fireDefenseValue() {
		return fireDefenseValue;
	}
	
	public void modifyFireDefenseValue(double amount) {
		fireDefenseValue += amount;
	}
	
	private double iceDefenseValue;
	public double iceDefenseValue() {
		return iceDefenseValue;
	}
	
	public void modifyIceDefenseValue(double amount) {
		iceDefenseValue += amount;
	}
	
	private double shockDefenseValue;
	public double shockDefenseValue() {
		return shockDefenseValue;
	}
	
	public void modifyShockDefenseValue(double amount) {
		shockDefenseValue += amount;
	}
	
	private int saveBonusPoison;
	public int saveBonusPoison() {
		return saveBonusPoison;
	}
	
	public void modifySaveBonusPoison(double amount) {
		saveBonusPoison += amount;
	}
	
	private int saveBonusFire;
	public int saveBonusFire() {
		return saveBonusFire;
	}
	
	public void modifySaveBonusFire(double amount) {
		saveBonusFire += amount;
	}
	
	private int saveBonusFrost;
	public int saveBonusFrost() {
		return saveBonusFrost;
	}
	
	public void modifySaveBonusFrost(double amount) {
		saveBonusFrost += amount;
	}
	
	private int saveBonusShock;
	public int saveBonusShock() {
		return saveBonusShock;
	}
	
	public void modifySaveBonusShock(double amount) {
		saveBonusShock += amount;
	}
	
	private int saveBonusAcid;
	public int saveBonusAcid() {
		return saveBonusAcid;
	}
	
	public void modifySaveBonusAcid(double amount) {
		saveBonusAcid += amount;
	}
	
	private int saveBonusPhysical;
	public int saveBonusPhysical() {
		return saveBonusPhysical;
	}
	
	public void modifySaveBonusPhysical(double amount) {
		saveBonusPhysical += amount;
	}
	
	private int saveBonusMagic;
	public int saveBonusMagic() {
		return saveBonusMagic;
	}
	
	public void modifySaveBonusMagic(double amount) {
		saveBonusMagic += amount;
	}
	
	private int saveBonusChaos;
	public int saveBonusChaos() {
		return saveBonusChaos;
	}
	
	public void modifySaveBonusChaos(double amount) {
		saveBonusChaos += amount;
	}
	
	private int resistsPhysical;
	public int resistsPhysical() {
		return resistsPhysical;
	}
	public void modifyResistsPhysical(int amount) {
		resistsPhysical += amount;
	}
	private int immunePhysical;
	public int immunePhysical() {
		return immunePhysical;
	}
	public void modifyImmunePhysical(int amount) {
		immunePhysical += amount;
	}
	
	private int resistsFire;
	public int resistsFire() {
		return resistsFire;
	}
	public void modifyResistsFire(int amount) {
		resistsFire += amount;
	}
	private int immuneFire;
	public int immuneFire() {
		return immuneFire;
	}
	public void modifyImmuneFire(int amount) {
		immuneFire += amount;
	}
	
	private int resistsFrost;
	public int resistsFrost() {
		return resistsFrost;
	}
	public void modifyResistsFrost(int amount) {
		resistsFrost += amount;
	}
	private int immuneFrost;
	public int immuneFrost() {
		return immuneFrost;
	}
	public void modifyImmuneFrost(int amount) {
		immuneFrost += amount;
	}
	
	private int resistsShock;
	public int resistsShock() {
		return resistsShock;
	}
	public void modifyResistsShock(int amount) {
		resistsShock += amount;
	}
	private int immuneShock;
	public int immuneShock() {
		return immuneShock;
	}
	public void modifyImmuneShock(int amount) {
		immuneShock += amount;
	}
	
	private int resistsPoison;
	public int resistsPoison() {
		return resistsPoison;
	}
	public void modifyResistsPoison(int amount) {
		resistsPoison += amount;
	}
	private int immunePoison;
	public int immunePoison() {
		return immunePoison;
	}
	public void modifyImmunePoison(int amount) {
		immunePoison += amount;
	}
	
	private int resistsAcid;
	public int resistsAcid() {
		return resistsAcid;
	}
	public void modifyResistsAcid(int amount) {
		resistsAcid += amount;
	}
	private int immuneAcid;
	public int immuneAcid() {
		return immuneAcid;
	}
	public void modifyImmuneAcid(int amount) {
		immuneAcid += amount;
	}
	
	private int resistsMagic;
	public int resistsMagic() {
		return resistsMagic;
	}
	public void modifyResistsMagic(int amount) {
		resistsMagic += amount;
	}
	private int immuneMagic;
	public int immuneMagic() {
		return immuneMagic;
	}
	public void modifyImmuneMagic(int amount) {
		immuneMagic += amount;
	}
	
	private int resistsChaos;
	public int resistsChaos() {
		return resistsChaos;
	}
	public void modifyResistsChaos(int amount) {
		resistsChaos += amount;
	}
	private int immuneChaos;
	public int immuneChaos() {
		return immuneChaos;
	}
	public void modifyImmuneChaos(int amount) {
		immuneChaos += amount;
	}
	
	private Effect quaffEffect;
	public Effect quaffEffect() {
		return quaffEffect;
	}
	
	public void setQuaffEffect(Effect effect) {
		this.quaffEffect = effect;
	}
	
	public Effect enchantmentEffect;
	public Effect enchantmentEffect() {
		return (Effect) enchantmentEffect.clone();
	}
	
	public void setEnchantmentEffect(Effect effect) {
		//this.enchantmentEffect = effect;
		this.enchantmentEffect = (Effect) effect.clone();
	}
	
	public Effect curseEffect;
	public Effect curseEffect() {
		return (Effect) curseEffect.clone();
	}
	
	public void setCurseEffect(Effect effect) {
		//this.enchantmentEffect = effect;
		this.curseEffect = (Effect) effect.clone();
	}
	
	private int isEnchanted;
	public int isEnchanted() {
		return isEnchanted;
	}
	
	public void modifyIsEnchanted(int amount) {
		isEnchanted += amount;
	}
	
	private List<Spell> writtenSpells;
	public List<Spell> writtenSpells(){
		return writtenSpells;
	}
	
	public void addWrittenSpell(Spell spell) {
		writtenSpells.add(spell);
	}
	
	private int isDegraded;
	public int isDegraded() {
		return isDegraded;
	}
	public void modifyIsDegraded(int amount) {
		isDegraded += amount;
	}
	
	private int isCursed;
	public int isCursed() {
		return isCursed;
	}
	public void modifyIsCursed(int amount) {
		isCursed += amount;
	}
	
	private int curseKnown;
	public int curseKnown() {
		return curseKnown;
	}
	public void modifyCurseKnown(int amount) {
		curseKnown += amount;
	}
	
	private int isWeapon;
	public int isWeapon() {
		return isWeapon;
	}
	public void modifyIsWeapon(int amount) {
		isWeapon += amount;
	}
	
	private int isRangedWeapon;
	public int isRangedWeapon() {
		return isRangedWeapon;
	}
	public void modifyIsRangedWeapon(int amount) {
		isRangedWeapon += amount;
	}
	
	private int isMeleeWeapon;
	public int isMeleeWeapon() {
		return isMeleeWeapon;
	}
	public void modifyIsMeleeWeapon(int amount) {
		isMeleeWeapon += amount;
	}
	
	private int isThrownWeapon;
	public int isThrownWeapon() {
		return isThrownWeapon;
	}
	public void modifyIsThrownWeapon(int amount) {
		isThrownWeapon += amount;
	}
	
	private int isTwoHanded;
	public int isTwoHanded() {
		return isTwoHanded;
	}
	public void modifyIsTwoHanded(int amount) {
		isTwoHanded += amount;
	}
	
	private int isVersatile;
	public int isVersatile() {
		return isVersatile;
	}
	public void modifyIsVersatile(int amount) {
		isVersatile += amount;
	}
	
	private int versatileDamageDice;
	public int versatileDamageDice() {
		return versatileDamageDice;
	}
	public void modifyVersatileDamageDice(int amount) {
		versatileDamageDice += amount;
	}
	
	private int isArmor;
	public int isArmor() {
		return isArmor;
	}
	public void modifyIsArmor(int amount) {
		isArmor += amount;
	}
	
	private int isLightArmor;
	public int isLightArmor() {
		return isLightArmor;
	}
	public void modifyIsLightArmor(int amount) {
		isLightArmor += amount;
	}
	
	private int isMediumArmor;
	public int isMediumArmor() {
		return isMediumArmor;
	}
	public void modifyIsMediumArmor(int amount) {
		isMediumArmor += amount;
	}
	
	private int isHeavyArmor;
	public int isHeavyArmor() {
		return isHeavyArmor;
	}
	public void modifyIsHeavyArmor(int amount) {
		isHeavyArmor += amount;
	}
	
	private int isTowerShield;
	public int isTowerShield() {
		return isTowerShield;
	}
	public void modifyIsTowerShield(int amount) {
		isTowerShield += amount;
	}
	
	private int isFinesse;
	public int isFinesse() {
		return isFinesse;
	}
	
	public void modifyIsFinesse(int amount) {
		isFinesse += amount;
	}
	
	private int isSimple;
	public int isSimple() {
		return isSimple;
	}
	
	public void modifyIsSimple(int amount) {
		isSimple += amount;
	}
	
	private int isMartial;
	public int isMartial() {
		return isMartial;
	}
	
	public void modifyIsMartial(int amount) {
		isSimple += amount;
	}
	
	private int isFortitude;
	public int isFortitude() {
		return isFortitude;
	}
	
	public void modifyIsFortitude(int amount) {
		isFortitude += amount;
	}
	
	private int isEvocation;
	public int isEvocation() {
		return isEvocation;
	}
	
	public void modifyIsEvocation(int amount) {
		isEvocation += amount;
	}
	
	private int isPyromancy;
	public int isPyromancy() {
		return isPyromancy;
	}
	
	public void modifyIsPyromancy(int amount) {
		isPyromancy += amount;
	}
	
	private int isCryomancy;
	public int isCryomancy() {
		return isCryomancy;
	}
	
	public void modifyIsCryomancy(int amount) {
		isCryomancy += amount;
	}
	
	private int isElectromancy;
	public int isElectromancy() {
		return isElectromancy;
	}
	
	public void modifyIsElectromancy(int amount) {
		isElectromancy += amount;
	}
	
	private int isAlchemancy;
	public int isAlchemancy() {
		return isAlchemancy;
	}
	
	public void modifyIsAlchemancy(int amount) {
		isAlchemancy += amount;
	}
	
	private int skillRestriction;
	public int skillRestriction() {
		return skillRestriction;
	}
	
	public void modifySkillRestriction(int amount) {
		skillRestriction += amount;
	}
	public void setSkillRestriction(int amount) {
		skillRestriction = amount;
	}
	
	private int armorClass;
	public int armorClass() {
		return armorClass;
	}
	public void modifyArmorClass(int amount) {
		armorClass += amount;
	}
	
	private int strength;
	public int strength() {
		return strength;
	}
	public void modifyStrength(int amount) {
		strength += amount;
	}
	
	private int dexterity;
	public int dexterity() {
		return dexterity;
	}
	public void modifyDexterity(int amount) {
		dexterity += amount;
	}
	
	private int intelligence;
	public int intelligence() {
		return intelligence;
	}
	public void modifyIntelligence(int amount) {
		intelligence += amount;
	}
	
	private int isRing;
	public int isRing() {
		return isRing;
	}
	public void modifyIsRing(int amount) {
		isRing += amount;
	}
	
	private int isShield;
	public int isShield() {
		return isShield;
	}
	public void modifyIsShield(int amount) {
		isShield += amount;
	}
	
	private int equippable;
	public int equippable() {
		return equippable;
	}
	public void modifyEquippable(int amount) {
		equippable += amount;
	}
	
	private int isTrap;
	public int isTrap() {
		return isTrap;
	}
	public void modifyIsTrap(int amount) {
		isTrap += amount;
	}
	
	private int isFound;
	public int isFound() {
		return isFound;
	}
	public void modifyIsFound(int amount) {
		isFound += amount;
	}
	
	private int isWand;
	public int isWand() {
		return isWand;
	}
	public void modifyIsWand(int amount) {
		isWand += amount;
	}
	
	private int isSpellbook;
	public int isSpellbook() {
		return isSpellbook;
	}
	public void modifyIsSpellbook(int amount) {
		isSpellbook += amount;
	}
	
	private int isKey;
	public int isKey() {
		return isKey;
	}
	public void modifyIsKey(int amount) {
		isKey += amount;
	}
	
	private int keyDepth;
	public int keyDepth() {
		return keyDepth;
	}
	public void setKeyDepth(int amount) {
		keyDepth = amount;
	}
	
	private int isAmmunition;
	public int isAmmunition() {
		return isAmmunition;
	}
	public void modifyIsAmmunition(int amount) {
		isAmmunition += amount;
	}
	
	private int ammunitionAmount;
	public int ammunitionAmount() {
		return ammunitionAmount;
	}
	public void modifyAmmunitionAmount(int amount) {
		ammunitionAmount += amount;
	}
	
	private int isArrows;
	public int isArrows() {
		return isArrows;
	}
	public void modifyIsArrows(int amount) {
		isArrows += amount;
	}
	
	private int isBolts;
	public int isBolts() {
		return isBolts;
	}
	public void modifyIsBolts(int amount) {
		isBolts += amount;
	}
	
	private int isPowder;
	public int isPowder() {
		return isPowder;
	}
	public void modifyIsPowder(int amount) {
		isPowder += amount;
	}
	
	private int usesArrows;
	public int usesArrows() {
		return usesArrows;
	}
	public void modifyUsesArrows(int amount) {
		usesArrows += amount;
	}
	
	private int usesBolts;
	public int usesBolts() {
		return usesBolts;
	}
	public void modifyUsesBolts(int amount) {
		usesBolts += amount;
	}
	
	private int usesPowder;
	public int usesPowder() {
		return usesPowder;
	}
	public void modifyUsesPowder(int amount) {
		usesPowder += amount;
	}
	
	private int isScroll;
	public int isScroll() {
		return isScroll;
	}
	public void modifyIsScroll(int amount) {
		isScroll += amount;
	}
	
	private int isIdentified;
	public int isIdentified() {
		return isIdentified;
	}
	public void modifyIsIdentified(int amount) {
		isIdentified += amount;
	}
	
	private int upgradeLevel;
	public int upgradeLevel() {
		return upgradeLevel;
	}
	public void modifyUpgradeLevel(int amount) {
		upgradeLevel += amount;
	}
	
	
	
	public String details() {
		String details = "";
		details += "   Value: "+currentGoldValue+" Gold";
		if(damageDice != 0) {
			details += "   Damage: "+damageDice;
		}
		if(rangedDamageDice != 0) {
			details += "   Ranged Damage: "+rangedDamageDice;
		}
		if(thrownDamageDice != 0) {
			details += "   Thrown Damage: "+thrownDamageDice;
		}
		if(armorClass != 0) {
			details += "   Armor Class: "+armorClass;
		}
		if(fireDefenseValue != 0) {
			details += "   Fire Resistance: "+fireDefenseValue;
		}
		if(iceDefenseValue != 0) {
			details += "   Frost Resistance: "+iceDefenseValue;
		}
		if(shockDefenseValue != 0) {
			details += "   Shock Resistance: "+shockDefenseValue;
		}
		if(foodValue != 0) {
			details += "   Food: "+foodValue;
		}
		if(ammunitionAmount != 0) {
			details += "   Ammunition: "+ammunitionAmount;
		}
		
		return details;
	}
	
	public Item(char glyph, Color color, String name, String appearance) {
		this.glyph = glyph;
		this.defaultGlyph = glyph;
		this.color = color;
		this.defaultColor = color;
		this.name = name;
		this.defaultName = name;
		this.upgradeName = "";
		this.enchantedName = "";
		this.thrownDamageDice = 1;
		this.writtenSpells = new ArrayList<Spell>();
		this.appearance = appearance;
		this.stackAmount = 1;
	}
	
	public Object clone(){
		try {
			return super.clone();
		}
		catch (CloneNotSupportedException e) {
			// This should never happen
			throw new InternalError(e.toString());
		}
	}

}
